using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Miln
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            var accur = Convert.ToDouble(ChooseAccurance.Text);
            var start_x = slider_x.Value;
            var start_y = slider_y.Value;
            var x_end = end_x.Value;
            MilnMethod mm = new MilnMethod();
            if ((start_x != x_end) && (start_x < x_end))
            {
                mm.Start(start_y, start_x, x_end, accur);
                System.Windows.Forms.Application.Run(new lab3.Form1(mm.GetCount, mm.GetX, mm.GetY));
            }
            else
            {
                MessageBoxResult mb = System.Windows.MessageBox.Show("Начальное и конечное значения равны или начальное больше конечного!.", "Ошибка!", MessageBoxButton.OK, MessageBoxImage.Error);
            }

        }
    }
}
