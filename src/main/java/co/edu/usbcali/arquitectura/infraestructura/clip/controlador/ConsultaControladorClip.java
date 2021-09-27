package co.edu.usbcali.arquitectura.infraestructura.clip.controlador;

import co.edu.usbcali.arquitectura.aplicacion.consulta.ManejadorListarClips;
import co.edu.usbcali.arquitectura.aplicacion.consulta.ManejadorListarClipsPalabrasMayorIgualA;
import co.edu.usbcali.arquitectura.aplicacion.consulta.ManejadorListarClipsGroseros;
import co.edu.usbcali.arquitectura.aplicacion.consulta.ManejadorListarClipsPalabrasMenorA;
import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clips")
public class ConsultaControladorClip {
    private final ManejadorListarClips manejadorListarClips;
    private final ManejadorListarClipsPalabrasMenorA manejadorListarClipsTresPalabras;
    private final ManejadorListarClipsPalabrasMayorIgualA manejadorListarClipsDiezPalabras;
    private final ManejadorListarClipsGroseros manejadorListarClipsGroseros;

    public ConsultaControladorClip(ManejadorListarClips manejadorListarClips, ManejadorListarClipsPalabrasMenorA manejadorListarClipsTresPalabras, ManejadorListarClipsPalabrasMayorIgualA manejadorListarClipsDiezPalabras, ManejadorListarClipsGroseros manejadorListarClipsGroseros) {
        this.manejadorListarClips = manejadorListarClips;
        this.manejadorListarClipsTresPalabras = manejadorListarClipsTresPalabras;
        this.manejadorListarClipsDiezPalabras = manejadorListarClipsDiezPalabras;
        this.manejadorListarClipsGroseros = manejadorListarClipsGroseros;
    }

    @GetMapping()
    public ResponseEntity<List<DtoClip>> listar() {
        return new ResponseEntity<>(this.manejadorListarClips.ejecutar(), HttpStatus.OK);
    }

    @GetMapping("/palabras/menor/{cantidad}")
    public ResponseEntity<List<DtoClip>> listarMenorATresPalabras(@PathVariable int cantidad) {
        return new ResponseEntity<>(this.manejadorListarClipsTresPalabras.ejecutar(cantidad), HttpStatus.OK);
    }

    @GetMapping("/palabras/mayor/{cantidad}")
    public ResponseEntity<List<DtoClip>> listarMayorIgualADiezPalabras(@PathVariable int cantidad) {
        return new ResponseEntity<>(this.manejadorListarClipsDiezPalabras.ejecutar(cantidad), HttpStatus.OK);
    }

    @GetMapping("/palabras/groseras")
    public ResponseEntity<List<DtoClip>> listarClipPalabrasGrosera() {
        return new ResponseEntity<>(this.manejadorListarClipsGroseros.ejecutar(), HttpStatus.OK);
    }
}
