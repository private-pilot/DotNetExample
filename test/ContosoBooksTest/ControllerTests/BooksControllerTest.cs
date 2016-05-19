using ContosoBooks.Controllers;
using ContosoBooks.Models;
using Microsoft.Data.Entity;
using NUnit.Framework;
using System.Linq;

namespace ContosoBooksTest.ControllerTests
{
    [TestFixture]
    public class BooksControllerTest
    {
        private ApplicationDbContext databaseContext;
        private BooksController booksController;

        [OneTimeSetUp]
        public void Initialize()
        {
            var optionsBuilder = new DbContextOptionsBuilder<ApplicationDbContext>();
            optionsBuilder.UseInMemoryDatabase();
            databaseContext = new ApplicationDbContext(optionsBuilder.Options);
            booksController = new BooksController(databaseContext);

            var austen = databaseContext.Author.Add(
                    new Author { LastName = "Austen", FirstMidName = "Jane" }).Entity;
            var dickens = databaseContext.Author.Add(
                new Author { LastName = "Dickens", FirstMidName = "Charles" }).Entity;
            var cervantes = databaseContext.Author.Add(
                new Author { LastName = "Cervantes", FirstMidName = "Miguel" }).Entity;
            var test = databaseContext.Author.Add(
                new Author { LastName = "TestLastName", FirstMidName = "TestFirstMidName" }).Entity;

            databaseContext.Book.AddRange(
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
            databaseContext.SaveChanges();
        }

        [Test]
        public void GetBooksList()
        {
            Assert.AreEqual(5, databaseContext.Book.Count());
        }
    }
}
