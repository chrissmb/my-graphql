# Queries


getBook(id: ID): Book
```
query ($id: ID) {
    getBook(id: $id) {
        id
        title
        year
        author {
            id
            name
        }
    }
}
```

getBooks: [Book]
```
{
    getBooks {
        id
        title
        year
        author {
            id
            name
        }
    }
}

// Query Variables
{
	"id": 1
}
```

saveBook(book: BookInput): Book
```
mutation ($bookInput: BookInput) {
     saveBook(book: $bookInput) {
        id
        title
        year
        author {
            id
            name
        }
    }
}

// Query Variables
{
    "bookInput": {
        "title": "Some Book Title",
        "year": 2010
    }
}
```