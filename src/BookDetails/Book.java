package BookDetails;

public class Book {
    int id;
    String name;
    String publisher;
    float price;
    String author;
    void Book(int ID,String name,String publisher,float price,String author)
    {
        this.id=ID;
        this.name=name;
        this.publisher=publisher;
        this.price=price;
        this.author=author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
