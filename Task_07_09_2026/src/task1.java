class Book {
    String title;
    int pages;

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }
}

void main() {
    Book book1 = new Book("Знамение", 350);
    Book book2 = new Book("Война алой и белой розы", 520);

    System.out.println("Книга первая: " + book1.title + ", страниц: " + book1.pages);
    System.out.println("Книга вторая: " + book2.title + ", страниц: " + book2.pages);
}