package co.edu.usbcali.arquitectura.infraestructura.configuracion;

import co.edu.usbcali.arquitectura.dominio.puerto.dao.DaoClip;
import co.edu.usbcali.arquitectura.dominio.puerto.repositorio.RepositorioClip;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasGroseras;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMayorIgualA;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioEliminarClipsPalabrasMenorA;
import co.edu.usbcali.arquitectura.dominio.servicio.ServicioGuardarClip;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    @Bean
    public ServicioGuardarClip servicioGuardarClip(RepositorioClip repositorioClip) {
        return new ServicioGuardarClip(repositorioClip);
    }

    @Bean
    public ServicioEliminarClipsPalabrasMenorA servicioEliminarClipsPalabrasMenorA(RepositorioClip repositorioClip, DaoClip daoClip) {
        return new ServicioEliminarClipsPalabrasMenorA(repositorioClip, daoClip);
    }

    @Bean
    public ServicioEliminarClipsPalabrasMayorIgualA servicioEliminarClipsPalabrasMayorIgualA(RepositorioClip repositorioClip, DaoClip daoClip) {
        return new ServicioEliminarClipsPalabrasMayorIgualA(repositorioClip, daoClip);
    }

    @Bean
    public ServicioEliminarClipsPalabrasGroseras servicioEliminarClipsPalabrasGroseras(RepositorioClip repositorioClip, DaoClip daoClip) {
        return new ServicioEliminarClipsPalabrasGroseras(repositorioClip, daoClip);
    }

}
