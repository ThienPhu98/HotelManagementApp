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
import javax.validation.constraints.*;
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

    @NotBlank(message = "The phone is required")
    @Size(min = 10, max = 11, message = "phone number invalid! phone number long must be 10 or 11")
    private String phone;

    @NotBlank(message = "The address is required")
    private String address;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(columnDefinition = "boolean default false")
    private boolean checkedIn;

    @Digits(integer = 12, fraction = 0, message = "guaranteeFee invalid! guarantee fee must be 0 or less than 1 billion")
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
