package co.edu.usbcali.arquitectura.aplicacion.comando;

public class ComandoClip {
    private Long id;
    private String subtitulos;
    private String url;

    public ComandoClip() {
    }

    public ComandoClip(Long id, String subtitulos, String url) {
        this.id = id;
        this.subtitulos = subtitulos;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtitulos() {
        return subtitulos;
    }

    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
