package co.edu.usbcali.arquitectura.dominio.servicio;

import co.edu.usbcali.arquitectura.dominio.modelo.entidad.Clip;
import co.edu.usbcali.arquitectura.dominio.modelo.mapeo.DtoClipMapeo;
import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;

import java.util.List;

public class ServicioEliminarClipsPalabrasGroseras {
    private final RepositorioClip repositorioClip;
    private final DaoClip daoClip;

    public ServicioEliminarClipsPalabrasGroseras(RepositorioClip repositorioClip, DaoClip daoClip) {
        this.repositorioClip = repositorioClip;
        this.daoClip = daoClip;
    }

    public void ejecutar() {
        List<Clip> clips = DtoClipMapeo.mapClip(this.daoClip.listarClipsPalabrasGroseras());
        this.repositorioClip.eliminarTodos(clips);
    }
}
