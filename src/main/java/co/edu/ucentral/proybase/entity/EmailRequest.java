package co.edu.ucentral.proybase.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

        private String to;
        private String subject;
        private String body;

}
