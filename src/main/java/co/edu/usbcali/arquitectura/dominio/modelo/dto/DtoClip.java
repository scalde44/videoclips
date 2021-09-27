package co.edu.usbcali.arquitectura.dominio.modelo.dto;

public class DtoClip {
    private Long id;
    private String subtitulos;
    private String url;

    public DtoClip() {
    }

    public DtoClip(Long id, String subtitulos, String url) {
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
}
