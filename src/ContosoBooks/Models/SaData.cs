using Microsoft.Data.Entity;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Linq;

namespace ContosoBooks.Models
{
    public static class SaData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            var context = serviceProvider.GetService<ApplicationDbContext>();
            context.Database.Migrate();
            if (!context.Book.Any())
            {
                var austen = context.Author.Add(
                    new Author { LastName = "Austen", FirstMidName = "Jane" }).Entity;
                var dickens = context.Author.Add(
                    new Author { LastName = "Dickens", FirstMidName = "Charles" }).Entity;
                var cervantes = context.Author.Add(
                    new Author { LastName = "Cervantes", FirstMidName = "Miguel" }).Entity;
                var test = context.Author.Add(
                    new Author { LastName = "TestLastName", FirstMidName = "TestFirstMidName" }).Entity;

                context.Book.AddRange(
                    new Book()
                    {
                        Title = "Pride and Prejudice",
                        Year = 1813,
                        Author = austen,
                        Price = 9.99M,
                        Genre = "Comedy of manners"
                    },
                    new Book()
                    {
                        Title = "Northanger Abbey",
                        Year = 1817,
                        Author = austen,
                        Price = 12.95M,
                        Genre = "Gothic parody"
                    },
                    new Book()
                    {
                        Title = "David Copperfield",
                        Year = 1850,
                        Author = dickens,
                        Price = 15,
                        Genre = "Bildungsroman"
                    },
                    new Book()
                    {
                        Title = "Don Quixote",
                        Year = 1617,
                        Author = cervantes,
                        Price = 8.95M,
                        Genre = "Picaresque"
                    },
                    new Book()
                    {
                        Title = "TestBook",
                        Year = 2016,
                        Author = test,
                        Price = 18.95M,
                        Genre = "test genre"
                    }
                );
                context.SaveChanges();
            }
            else
            {
                string oldBookTitle = "fancier book";
                string newBookTitle = "New Book";

                Book book = context.Book.Where(x => x.Title.Equals(oldBookTitle, StringComparison.OrdinalIgnoreCase)).FirstOrDefault();

                book.Title = newBookTitle;

                context.SaveChanges();
            }
        }
    }
}