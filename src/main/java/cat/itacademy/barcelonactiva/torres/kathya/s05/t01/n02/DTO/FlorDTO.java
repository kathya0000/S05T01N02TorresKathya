package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n02.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class FlorDTO {
    private long pk_FlorID;
    private String nameFlor;
    private String paisFlor;
    private String TipoFlor;

    private static final List<String> paisesUE = Arrays.asList(
            "Alemania", "Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca",
            "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia",
            "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta",
            "Países Bajos", "Polonia", "Portugal", "República Checa", "Rumanía", "Suecia"
    );

    public void determinarTipoFlor() {
        this.TipoFlor = paisesUE.contains(this.paisFlor) ? "UE" : "Fuera UE";
    }
}
