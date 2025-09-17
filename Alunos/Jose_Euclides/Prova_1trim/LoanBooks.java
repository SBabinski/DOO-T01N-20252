package Alunos.Jose_Euclides.Prova_1trim;

import java.time.LocalDate;

public class LoanBooks {
    private String idBook;
    private String cpfCustomer;
    private LocalDate dateDoneLoan;
    private LocalDate dateToBack;
    private LocalDate dateBackBook;

    private void printItIsntPossible() {
        System.out.println("Não é possível alterar esse campo!");
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        if (this.idBook == null) {
            this.idBook = idBook;
        } else {
            printItIsntPossible();
        }
    }

    public String getCpfCustomer() {
        return cpfCustomer;
    }

    public void setCpfCustomer(String cpfCustomer) {
        if (this.cpfCustomer == null) {
            this.cpfCustomer = cpfCustomer;
        } else {
            printItIsntPossible();
        }
    }

    public LocalDate getDateDoneLoan() {
        return dateDoneLoan;
    }

    public void setDateDoneLoan(LocalDate dateDoneLoan) {
        if (this.dateDoneLoan == null) {
            this.dateDoneLoan = dateDoneLoan;
        } else {
            printItIsntPossible();
        }
    }

    public LocalDate getDateToBack() {
        return dateToBack;
    }

    public void setDateToBack(LocalDate dateToBack) {
        if (this.dateToBack == null) {
            this.dateToBack = dateToBack;
        } else {
            printItIsntPossible();
        }
    }

    public LocalDate getDateBackBook() {
        return dateBackBook;
    }

    public void setDateBackBook(LocalDate dateBackBook) {
        if (this.dateBackBook == null) {
            this.dateBackBook = dateBackBook;
        } else {
            printItIsntPossible();
        }
    }
}
