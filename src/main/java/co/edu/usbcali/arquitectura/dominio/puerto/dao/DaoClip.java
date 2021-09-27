package co.edu.usbcali.arquitectura.dominio.puerto.dao;

import co.edu.usbcali.arquitectura.dominio.modelo.dto.DtoClip;

import java.util.List;

public interface DaoClip {
    /**
     * Permite listar los clips
     *
     * @return los clips
     */
    List<DtoClip> listarClips();

    /**
     * Permite listar los clips con menos de tres palabras
     *
     * @return los clips
     */
    List<DtoClip> listarClipsPalabrasMenorA(int cantidadPalabras);

    /**
     * Permite listar los clips con igual o mas de diez palabras
     *
     * @return los clips
     */
    List<DtoClip> listarClipsPalabrasMayorIgualA(int cantidadPalabras);

    /**
     * Permite listar los clips con palabras groseras
     *
     * @return los clips
     */
    List<DtoClip> listarClipsPalabrasGroseras();
}
