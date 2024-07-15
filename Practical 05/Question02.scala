import scala.io.StdIn._

object Question02 {
    class book(val title : String, val author : String, val isbn : String) {    //Primary Constructor
        def displayBookDetails() : Unit = {
            println(f"Title = ${title}");
            println(f"Author = ${author}");
            println(f"ISBN = ${isbn}");
            println("");
        }
    }

    def main(args:Array[String]) : Unit = {
        var library = Set(new book("Percy Jackson and Lightning Thief", "Rick Riordan", "978-0-7868-5629-9"), new book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-1-3382-9914-4"), new book("The Hobbit", "J.R.R. Tolkien", "978-0-3453-3968-3"), new book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "978-0-4390-6486-6"));
        library = librarySystem(library);
        
    }

    //Function to handle library interface
    def librarySystem(libraryOriginal:Set[book]) : Set[book] = {
        var library = libraryOriginal;
        var systemStatus = true;
        while(systemStatus) {
            println(f"\nLibrary System\n");
            println(f"1. Add book");
            println(f"2. Remove book");
            println(f"3. Search book by ISBN");
            println(f"4. Display Library");
            println(f"5. Search book by Title");
            println(f"6. Filter books by author");
            println(f"7. Exit")
            print("Select option: ");
            readInt() match {
                case 1 => library = addBook(library, getBookDetails());
                case 2 => library = removeBook(library, getISBN()); println(f"\nBook has been removed successfully\n"); 
                case 3 => searchBookByISBN(library, getISBN());
                case 4 => println(f"\nLibrary\n"); displayLibrary(library); println("");
                case 5 => searchBookByTitle(library, getTitle());
                case 6 => displayBooksByAuthor(library, getAuthor());
                case 7 => println(f"\nThank you for using the library system\n"); systemStatus = false;
                case _ => println(f"\nPlease enter a valid option!!\n")
                
            }
        }
        library;
    }

    //Function to get book details
    def getBookDetails() : book = {
        val book = new book(getTitle(), getAuthor(), getISBN());
        book;
        
    }

    //Function to get ISBN from user
    def getISBN() : String = {
        print(f"\nPlease enter ISBN: ");
        val isbn = readLine();
        isbn;
    }

    //Function to get title from user
    def getTitle() : String = {
        print(f"\nPlease enter Title: ");
        val title = readLine();
        title;
    }

    //Function to get author from user
    def getAuthor() : String = {
        print(f"\nPlease enter Author: ");
        val author = readLine();
        author;
    }
    
    //Function to check if book is in the system
    def bookExists(library:Set[book], ISBN:String) : Boolean = {
        library.exists(_.isbn == ISBN);
    }

    //Function to add book to system
    def addBook(library:Set[book], newBook:book) : Set[book] = {
        bookExists(library, newBook.isbn) match {
            case true => 
                println(f"\nBook already exists\n"); 
                library;
            case false => 
                println(f"\nBook has been added successfully\n"); 
                library + newBook;
        }
        
    }

    //Function to remove book given the ISBN number
    def removeBook(library:Set[book], ISBN:String) : Set[book] = {
        library.filterNot(_.isbn == ISBN);
    }

    //Function to search a book given ISBN number
    def searchBookByISBN(library:Set[book], ISBN:String) : Unit = {
        bookExists(library, ISBN) match {
            case true => println(f"Book exists in library\n");
            case false => println(f"Book doesn't exist in library\n");
        }
    }

    //Function to display all elements of Set[book]
    def displayLibrary(library:Set[book]) : Unit = {
        library.foreach(_.displayBookDetails());
    }

    //Function to search book by title
    def searchBookByTitle(library:Set[book], title:String) : Unit = {
        library.exists(_.title == title) match {
            case true => displayLibrary(library.filter(_.title == title)); println("");
            case false => println(f"\n${title} book not available");
        }
    }

    //Function to display all books by an author
    def displayBooksByAuthor(library:Set[book], author:String) : Unit = {
        library.exists(_.author == author) match {
            case true => println(f"\nBooks by ${author}\n"); displayLibrary(library.filter(_.author == author));
            case false => println(f"\n${author} has no books available");
        }
    }

}