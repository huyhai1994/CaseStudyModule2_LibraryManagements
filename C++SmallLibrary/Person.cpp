#include <iostream>
#include <string.h>
#include <list>

using namespace std;

class Person;

class Book
{
public:
    Book()
    {
        person = 0;
    }
    bool operator==(const Book &bk) const
    {
        return strcmp(title, bk.title) == 0;
    }

private:
    char *title;
    Person *person;
    friend ostream &operator<<(ostream &os, const Book &);
    friend ostream &operator<<(ostream &os, const Person &);
    friend class CheckedOutBook;
    friend void includeBook();
    friend void checkOutBook();
    friend void returnBook();
};

class Author{
    public : 
    Author(){
    }
     bool operator==(const Author &ar) const{
        return strcmp(name, ar.name) == 0;
    }    
    bool operator==(const Author &ar) const
    {
        return strcmp(name, ar.name) == 0;
    }    
     bool operator==(const Author &ar) const
    {
        return strcmp(name, ar.name) == 0;
    }    
    bool operator==(const Author &ar) const
    {
        return strcmp(name, ar.name) == 0;
    }    
    char* name;
    list<Book*>books;
    friend ostream& operator<< (ostream& os, const Author&);
    friend ostream& operator << (ostream& os, const Person&);
    friend class CheckedOutBook;
    friend void includeBook();
    friend void checkOutBook();
    friend void returnBook();
};

class CheckedOutBook{
    public: 
    checkedOutBook(Author *ar = 0, Book *bk = 0){
        author = ar;
        book = bk;
    }
    bool operator == (const CheckedOutBook& bk) const {
        return strcmp (author->name, bk->name) == 0 &&
        strcmp(book->title, bk.book->title) ==0;
    }
    bool operator!= (const CheckedOutBook& bk) const {
        return !(*this == bk);
    }
    bool operator< (const CheckedOutBook& bk) const {
        if(strcmp(author->name, bk.author->name)==0){
            return strcmp(book->title, bk.book->title) < 0;
        }
        return strcmp(author->name, bk.author->name) < 0;
    }
    bool operator>(const CheckedOutBook& bk) const {
        return !(*this==bk) && !(*this<bk);
    }
    private:
    Author* author;
    Book* book;
    friend ostream& operator<< (ostream&,const Person&);
    friend void checkOutBook();
    friend void returnBook();
};

class Person{
    public:
    Person(){
    }
    bool operator== (const Person& pn) const{
        return strcmp(name, pn.name) == 0;
    }
    private:
    char* name;
    list<CheckedOutBook*>books;
    friend ostream& operator<< (ostream& os, const Person&);
    friend ostream& operator<< (ostream& os, const Book&);
    friend void includeBook();
    friend void checkOutBook();
    friend void returnBook();
};
list<Author*> catalog['Z'+1];
list<Person*> people['Z'+1];

template <class T>
ostream& operator<< (ostream& os, const list<T*>& lst){
    for(list<T::iterator ref = 1st.begin(); ref != 1st.end(); ++ref)
    out<<**ref;
    return out;
}
ostream& operator<< (ostream& out, const Book& bk){
    out<< " *"<<bk.title;
    if(bk.person != 0){
        out<<" -checked out to"<<bk.person->name;
    }
    out<<endl;
    return out;
}

ostream& operator<<(ostream& out, const Author& ar){
    out<<ar.name<<endl<<ar.books;
    return out;
}
ostream& operator<<(ostream& out, const Person& pr){
    out<<pr.name;
    if(!pr.books.empty()){
        out<<" has the following books: \n";
        list<CheckedOutBook>::iterator bk = pr.books.begin();
        for(;bk!=pr.books.end();bk++){
            out<< " *"<<bk->author->name<<", "<<bk->book->title<<endl;
        }
    } else {
        out<<" has no books.\n";
    }
    return out;
}
template <class T1, class T2>
List<T2> ::iterator findIt(const list<T2>& 1st,const T1&e1){
    for(list<T2>::iterator ref = 1st.begin(); ref!= 1st.end(); ++ref)
        if(**ref == e1)
         break;
    return ref;
}

char* getString(char* msg){
    char s[82], i, *destin;
    cout<<msg;
    cin.get(s,80);
    while(cin.get(s[81])&&s[81] !='\n');
    destin = new char[strlen(s)+1];
    for(i=0; destin[i] = toupper(s[i]); i++);
    return destin;    
}
void status(){
    register int i;
    cout<<"Library has the following books: \n\n";
    for(i='A'; i<='Z'; i++)
        if(!catalog[i].empty())
        cout<<catalog[i];
    cout<<"\n\nThe following people are using library: \n\n";
    for(i ='A';i<= 'Z';i++)
        if(!people[i].empty())
            cout<<people[i];
}

void includeBook(){
    Author *newAuthor = new Author;
    Book *newBook = new Book;
    newAuthor->name = getString("Enter author's name: ");
    newBook->title = getString("Enter book's title: ");
    list<Author *>::oldAuthor = findIt(catalog[newAuthor->name[0]],*newAuthor);
    if(oldAuthor == catalog[newAuthor->name[0]].end()){
        newAuthor->books.push_front(newBook);
        catalog[newAuthor->name[0]].push_front(newAuthor);
    }
    else (*oldAuthor)->books.push_front(newBook);
}
void checkOutBook(){
    Person *person = new Person;
    Author author;
    Book book;
    list<Author*>::iterator authoRef;
    list<Book*>::iterator bookRef;
    person->name = getString("Enter person's name: ");
    while(true){
        author.name = getString("Enter author's name: ");
        authoRef = findIt(catalog[author.name[0]],author);
        if(authoRef == catalog[author.name[0]].end())
            cout<<"Misspeled author's name.\n";
        else break;
    }
    while(true){
        book.title = getString("Enter book's title: ");
        bookRef = findIt((*authoRef)->books,book);
        if(bookRef == (*authoRef)->books.end())
            cout<<"Misspeled book's title.\n";
        else break;
    }
    list<Person*>::iterator personRef;
    personRef = findIt(people[person->name[0]],person);
    CheckedOutBook checkedOutBook (*authorRef,*bookRef);
    if (personRef == people[person->name[0]].end())
    {
        person->books.push_front(checkedOutBook);
        people[person->name[0]].push_front(person);
        (*bookRef)->person = *person[people->name[0]].begin();
    }
    else {
        (*personRef)->books.push_front(checkedOutBook);
        (*bookRef) -> person =*personRef;
    }    
}
void returnBook(){
    Person person;
    Book book;
    Author author;
    list<Person*>::iterator personRef;
    list<Book*>::iterator bookRef;
    list<Author*>::iterator authorRef;
    while(true){
        person.name = getString("Enter person's name: ");
        personRef = findIt(people[person.name[0]],person);
        if(personRef == people[person.name[0]].end())
            cout<<"Misspeled person's name.\n";
        else break;
    }
    while(true){
        author.name = getString("Enter Author Name: ");
        authorRef = findIt(catalog[author.name[0]],author);
        if(authorRef == catalog[author.namep[0]],author)
            cout<<"Mispelled Author Name: \n"<<endl;
        else break;
    }
    while(true){
        book.title = getString("Enter the tiltle of the book: ");
        bookRef = findIt((*authorRef)->books,book);
        if(bookRef == (*authorRef)->books.end())
            cout<<"Misspelled title\n";
        else break;
    }
    CheckedOutBook checkedOutBook(*authorRef,*bookRef);
    (*bookRef)->person = 0;
    (*personRef)->book.remove(checkedOutBook);
}
int menu(){
    int option;
    cout<<"\nEnter one of the following options: \n"
        <<"1. Include a book in the catalog: \n2. Check out a book\n"
        <<"3. Return a book\n4. Status\n5.Exit\n"
        <<"Enter your choice: ";
    cin>>option;
    cin.get();
    return option;
}
void main(){
    while(true){
        switch(menu()){
            case 1: includeBook(); break;
            case 2: checkOutBook(); break;
            case 3: returnBook(); break;
            case 4: status(); break;
            case 5: return;
            default: cout<<"Invalid option.\n";
        }
    }
}

