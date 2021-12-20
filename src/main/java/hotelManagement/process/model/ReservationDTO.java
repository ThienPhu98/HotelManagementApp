package hotelManagement.process.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private long bookingCode;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private BigDecimal guaranteeFee;
    private String methodPayment;
    private Room room;
}
