using System.Windows;

namespace RU_986676
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            var wnd = new MainWindow();
            var ctx = new MainViewModel();

            wnd.DataContext = ctx;
            wnd.Show();
        }
    }
}
