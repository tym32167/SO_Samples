using System;
using System.Data.SqlClient;
using System.Threading.Tasks;

namespace RU_985418
{
    class Program
    {
        static async Task Main(string[] args)
        {
            string conStr = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\Code\github\SO_Samples\src\RU_985418\DB\MyDatabaseSample.mdf;Integrated Security=True;Connect Timeout=30";
            using (var connection = new SqlConnection(conStr))
            {
                connection.Open();
                var command = new SqlCommand("SELECT [Id], [Name] FROM [SampleTable]", connection);
                var reader = await command.ExecuteReaderAsync();

                while (reader.Read())
                {
                    Console.WriteLine($"ID: {reader.GetInt32(0)}, Name: {reader.GetString(1)}");
                }
            }
        }
    }
}
