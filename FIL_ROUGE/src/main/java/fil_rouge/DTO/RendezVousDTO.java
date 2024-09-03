package fil_rouge.DTO;

import fil_rouge.Enums.Status;

import java.time.LocalDate;

public class RendezVousDTO {

    private Long id;
    private LocalDate date;
    private Status status;
    private Long donneurSangId;
    private Long centreCollecteId;

}