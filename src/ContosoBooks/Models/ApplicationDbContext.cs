using Microsoft.Data.Entity;
using Microsoft.Data.Entity.Infrastructure;

namespace ContosoBooks.Models
{
    public class ApplicationDbContext : DbContext
    {
        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
            // Customize the ASP.NET Identity model and override the defaults if needed.
            // For example, you can rename the ASP.NET Identity table names and more.
            // Add your customizations after calling base.OnModelCreating(builder);
        }
        public DbSet<Book> Book { get; set; }
        public DbSet<Author> Author { get; set; }

        public ApplicationDbContext(DbContextOptions options) : base(options)
        {
            var testOptions = options;
        }
    }
}