package co.edu.usbcali.arquitectura.dominio.servicio;

import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.modelo.mapeo.DtoClipMapeo;
import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;

import java.util.List;
import java.util.stream.Collectors;

public class ServicioEliminarClipsPalabrasMayorIgualA {
    private final RepositorioClip repositorioClip;
    private final DaoClip daoClip;

    public ServicioEliminarClipsPalabrasMayorIgualA(RepositorioClip repositorioClip, DaoClip daoClip) {
        this.repositorioClip = repositorioClip;
        this.daoClip = daoClip;
    }

    public void ejecutar(int cantidadPalabras) {
        List<Clip> clips = DtoClipMapeo.mapClip(this.daoClip.listarClipsPalabrasMayorIgualA(cantidadPalabras));
        this.repositorioClip.eliminarTodos(clips);
    }
}
