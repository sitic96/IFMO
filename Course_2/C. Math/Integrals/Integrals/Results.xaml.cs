using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Integrals
{
    /// <summary>
    /// Логика взаимодействия для Results.xaml
    /// </summary>
    public partial class Results : Window
    {
        public Results()
        {
            InitializeComponent();
            this.Show();
        }

        private void Show()
        {
            /*
             * go.Dispatcher.BeginInvoke(new Action(delegate()
                {
                    go.IsEnabled = false;
                }));
             */
            N.Dispatcher.BeginInvoke(new Action(delegate()
                {
                    N.Content = MainWindow.n;
                }));
            answer.Content = MainWindow.answer;
            pogresh.Content = MainWindow.pogr;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
