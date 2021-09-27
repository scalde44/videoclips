package co.edu.usbcali.arquitectura.dominio.modelo.entidad;

import co.edu.usbcali.arquitectura.dominio.excepcion.ExcepcionDuplicidad;

import java.util.Locale;

public class Clip {
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
}
