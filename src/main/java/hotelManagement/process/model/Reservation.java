package hotelManagement.process.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
@Entity
@Table(name = "reservations")
@Accessors(chain = true)
public class Reservation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingCode;

    @NotBlank(message = "The full name is required")
    private String fullName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "The email is required")
    @Email(message = "The email address is invalid")
    @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters")
    private String email;

    private String phone;
    private String address;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(columnDefinition = "boolean default false")
    private boolean checkedIn;

    @Digits(integer = 12, fraction = 0)
    @Column(updatable = false)
    private BigDecimal guaranteeFee;

    private String methodPayment;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = "Asia/Ho_Chi_Minh")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "room_type")
    private Room room;

    @Override
    public String toString() {
        return "Reservation{" +
                "bookingCode=" + bookingCode +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", deleted=" + deleted +
                ", checkedIn=" + checkedIn +
                ", guaranteeFee=" + guaranteeFee +
                ", methodPayment='" + methodPayment + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
