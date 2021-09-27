package co.edu.usbcali.arquitectura.infraestructura.clip.controlador;

import co.edu.usbcali.arquitectura.aplicacion.comando.ComandoClip;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.ManejadorEliminarClipsPalabrasGroseras;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.ManejadorEliminarClipsPalabrasMayorA;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.ManejadorEliminarClipsPalabrasMenorA;
import co.edu.usbcali.arquitectura.aplicacion.comando.manejador.ManejadorGuardarClip;
import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clips")
public class ComandoControladorClip {
    private final ManejadorGuardarClip manejadorGuardarClip;
    private final ManejadorEliminarClipsPalabrasMenorA manejadorEliminarClipsPalabrasMenorA;
    private final ManejadorEliminarClipsPalabrasMayorA manejadorEliminarClipsPalabrasMayorA;
    private final ManejadorEliminarClipsPalabrasGroseras manejadorEliminarClipsPalabrasGroseras;

    public ComandoControladorClip(ManejadorGuardarClip manejadorGuardarClip, ManejadorEliminarClipsPalabrasMenorA manejadorEliminarClipsPalabrasMenorA, ManejadorEliminarClipsPalabrasMayorA manejadorEliminarClipsPalabrasMayorA, ManejadorEliminarClipsPalabrasGroseras manejadorEliminarClipsPalabrasGroseras) {
        this.manejadorGuardarClip = manejadorGuardarClip;
        this.manejadorEliminarClipsPalabrasMenorA = manejadorEliminarClipsPalabrasMenorA;
        this.manejadorEliminarClipsPalabrasMayorA = manejadorEliminarClipsPalabrasMayorA;
        this.manejadorEliminarClipsPalabrasGroseras = manejadorEliminarClipsPalabrasGroseras;
    }

    @PostMapping()
    public ResponseEntity<Clip> guardar(@RequestBody ComandoClip comandoClip) {
        return new ResponseEntity<>(this.manejadorGuardarClip.ejecutar(comandoClip), HttpStatus.CREATED);
    }

    @DeleteMapping("/palabras/menor/{cantidad}")
    public ResponseEntity eliminarClipsPalabrasMenorA(@PathVariable int cantidad) {
        this.manejadorEliminarClipsPalabrasMenorA.ejecutar(cantidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/palabras/mayor/{cantidad}")
    public ResponseEntity eliminarClipsPalabrasMayorIgualA(@PathVariable int cantidad) {
        this.manejadorEliminarClipsPalabrasMayorA.ejecutar(cantidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/palabras/groseras")
    public ResponseEntity eliminarClipsPalabrasGroseras() {
        this.manejadorEliminarClipsPalabrasGroseras.ejecutar();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
