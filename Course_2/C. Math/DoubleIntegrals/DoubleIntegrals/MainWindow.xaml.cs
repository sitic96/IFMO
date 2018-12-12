using System.Windows;


namespace DoubleIntegrals
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

        private void button_Click(object sender, RoutedEventArgs e)
        {
            CalculateDoubleIntegral ci = new CalculateDoubleIntegral();
            double a = slider.Value;
            double b = slider3.Value;
            double c = slider1.Value;
            double d = slider2.Value;
            int m = System.Convert.ToInt16(slider4.Value);
            

            textBox.Text = System.Convert.ToString(ci.Start(a, b, c, d, m));
        }
    }
}
