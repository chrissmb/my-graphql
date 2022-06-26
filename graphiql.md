# Graphiql - Graphql playground

[base_url]/graphiql

```graphql
query {
	getBook(id: 1) {
		id
		title
		year
		author {
			name
		}
	}
}
```

```graphql
mutation($book: BookInput) {
  saveBook(book: $book) {
    id
    title
    year
    author {
      id
    }
  }
}

# Query variables
{
	"book": {
		"title": "Harry Potter",
		"year": 1999
	}
}
```