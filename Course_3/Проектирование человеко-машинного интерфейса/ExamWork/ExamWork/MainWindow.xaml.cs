using NAudio.Wave;
using System;
using System.IO;
using System.Net;
using System.Threading;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media.Imaging;
using System.Drawing;
using System.Windows.Interop;
using System.Windows.Threading;

namespace ExamWork
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void minimize_program(object sender, RoutedEventArgs e)
        {
            this.WindowState = WindowState.Minimized;
        }

        private void close_program(object sender, RoutedEventArgs e)
        {
            if (t != null)
            {
                t.Abort();
            }
            this.Close();
        }

        private void maximize_program(object sender, RoutedEventArgs e)
        {
            this.WindowState = WindowState.Maximized;
        }

        private void Window_MouseDown(object sender, MouseButtonEventArgs e)
        {
            if (e.ChangedButton == MouseButton.Left)
                DragMove();
        }
        static string url = "http://cdndl.zaycev.net/77795/1876454/One+Republic_-_I+Lived.mp3";
        Thread t;

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (t != null)
            {
                if (t.IsAlive)
                {
                    t.Abort();
                    t = new Thread(PlayMp3FromUrl);
                    t.Start();
                }
                else
                {
                    t = new Thread(PlayMp3FromUrl);
                    t.Start();
                }
            }
            else
            {
                t = new Thread(PlayMp3FromUrl);
                t.Start();
            }
           
        }

        private void Button_Click1(object sender, RoutedEventArgs e)
        {
            if (t.IsAlive)
            {
                t.Abort();
            }

        }

        public static void PlayMp3FromUrl()
        {
            using (Stream ms = new MemoryStream())
            {
                using (Stream stream = WebRequest.Create(url)
                    .GetResponse().GetResponseStream())
                {
                    byte[] buffer = new byte[32768];
                    int read;
                    while ((read = stream.Read(buffer, 0, buffer.Length)) > 0)
                    {
                        ms.Write(buffer, 0, read);
                    }
                }

                ms.Position = 0;
                using (WaveStream blockAlignedStream =
                    new BlockAlignReductionStream(
                        WaveFormatConversionStream.CreatePcmStream(
                            new Mp3FileReader(ms))))
                {
                    using (WaveOut waveOut = new WaveOut(WaveCallbackInfo.FunctionCallback()))
                    {
                        waveOut.Init(blockAlignedStream);
                        waveOut.Play();
                        while (waveOut.PlaybackState == PlaybackState.Playing)
                        {
                            System.Threading.Thread.Sleep(100);
                        }
                    }
                }
            }
        }
    }
}
