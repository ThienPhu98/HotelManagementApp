class App {

    static DOMAIN = location.origin;

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ');
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
    }

    static formatNumberSpace(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }

    static removeFormatNumberSpace(x) {
        return x.toString().replace(" ", "");
    }

    static formatTooltip() {
        $('[data-toggle="tooltip"]').tooltip();
    }
}


class Reservation {
    constructor(bookingCode, fullName, email, phone, address, guaranteeFee, methodPayment, room) {
        this.bookingCode = bookingCode;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.guaranteeFee = guaranteeFee;
        this.methodPayment = methodPayment;
        this.room = room;
    }
}

class Room {
    constructor(id, type, status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

}