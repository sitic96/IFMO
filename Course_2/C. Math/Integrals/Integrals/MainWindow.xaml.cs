using System;
using System.Threading;
using System.Windows;
using System.Windows.Controls;

namespace Integrals
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
        private static SolveIntegr si = new SolveIntegr();
        private double a, b, accur;
        private int number;
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if ((double.TryParse(up.Text, out a)) && (double.TryParse(down.Text, out b)))
            {
                accur = Convert.ToDouble(ChooseAccurance.Text);
                int j = 0;
                for (int i = 0; ; i++)
                {
                    if (main_grid.Children[i] is RadioButton)
                    {
                        j++;

                        if ((bool)((main_grid.Children[i] as RadioButton).IsChecked))
                        {
                            number = j;
                            break;
                        }
                    }
                    if (j == 5)
                    {
                        MessageBoxResult result = MessageBox.Show("Вы ничего не выбрали! Автоматически будет выбран номер 1.", "Ошибка!", MessageBoxButton.OK, MessageBoxImage.Error);
                        if (result == MessageBoxResult.OK) { number = 1; break; }
                    }
                }
                Thread th = new Thread(this.Th2);
                th.SetApartmentState(ApartmentState.STA);
                th.Start();
                 
            }
        }
        private object obj;
        private void Th2()
        {
            go.Dispatcher.BeginInvoke(new Action(delegate()
                {
                    go.IsEnabled = false;
                }));
            try { si.Start(number, a, b, accur); }
            catch
            {
                MessageBoxResult result = MessageBox.Show("Во время исполнения возникла ошбика. Возможно, вы ввели слишком маленькую точность.", "Ошибка!", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }
            go.Dispatcher.BeginInvoke(new Action(delegate()
            {
                go.IsEnabled = true;
            }));
            ShowResults();
        }
        public static int n;
        public static double answer, pogr;
        private static void ShowResults()
        {
            n = si.GetN;
            answer = si.GetAnswer;
            pogr = si.GetPogr;
            Results rs = new Results();
            rs.ShowDialog();
            si = new SolveIntegr();
        }
    }
}
