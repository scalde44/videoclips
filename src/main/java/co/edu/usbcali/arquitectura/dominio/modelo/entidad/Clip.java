package co.edu.usbcali.arquitectura.dominio.modelo.entidad;

import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionCantidad;

public class Clip {
    private static final String EL_CLIP_NO_CUMPLE_CON_LAS_PALABRAS = "El videoclip no cumple con las palabras minimas: %s";
    private static final int CANTIDAD_PALABRAS_MINIMAS_GUARDAR_CLIP = 10;
    public static final String[] PALABRAS_GROSERAS = {"MIERDA"};
    private Long id;
    private String subtitulos;
    private String url;

    public Clip() {
    }

    public Clip(Long id, String subtitulos, String url) {
        if (subtitulos == null || url == null) {
            throw new IllegalArgumentException("No ingrese objetos nulos");
        }
        this.id = id;
        this.subtitulos = subtitulos;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean contienePalabraGrosera() {
        boolean contiene = false;
        for (String groseria : PALABRAS_GROSERAS) {
            if (this.subtitulos.toUpperCase().contains(groseria)) {
                contiene = true;
            }
        }
        return contiene;
    }

    public void validarMinimoPalabrasGuardarClip() {
        String[] palabras = this.subtitulos.split(" ");
        int cantidad = palabras.length;
        if (cantidad < CANTIDAD_PALABRAS_MINIMAS_GUARDAR_CLIP) {
            throw new ExcepcionCantidad(String.format(EL_CLIP_NO_CUMPLE_CON_LAS_PALABRAS, CANTIDAD_PALABRAS_MINIMAS_GUARDAR_CLIP));
        }
    }
}
