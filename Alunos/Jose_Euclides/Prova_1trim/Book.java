package Alunos.Jose_Euclides.Prova_1trim;

public class Book {
    public String title;
    public String author;
    public boolean isSpecial;
    public String textWhyIsSpecial;

    public Book() {
        super();
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getTextWhyIsSpecial() {
        return textWhyIsSpecial;
    }

    public void setTextWhyIsSpecial(String textWhyIsSpecial) {
        this.textWhyIsSpecial = textWhyIsSpecial;
    }

    @Override
    public String toString() {
        return "Livro {" +
                "Titulo='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", É especial=" + isSpecial +
                ", texto do por quê é especial='" + textWhyIsSpecial + '\'' +
                '}';
    }

}
