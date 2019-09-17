using System;
using System.Threading;
using System.Windows;
using System.Windows.Controls;

namespace RU_1018395_Console
{
    class Program
    {
        [STAThread]
        static void Main(string[] args)
        {
            new MyWnd().ShowDialog();
        }
    }

    public class MyWnd : Window
    {
        private TextBlock tb;

        public MyWnd()
        {
            tb = new TextBlock() { Width = 300 };
            tb.FontSize = 72;
            this.Content = tb;
            this.SizeToContent = SizeToContent.WidthAndHeight;

            var thread = new Thread(Worker) { IsBackground = true };
            thread.Start();
        }


        private void Worker(object state)
        {
            for (var i = 0; i < 100; i++)
            {
                var t = i.ToString();
                this.Dispatcher.Invoke(() => { tb.Text = t; });
                Thread.Sleep(1000);
            }
        }
    }
}
