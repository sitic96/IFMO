using System;

namespace Miln
{
    public class MilnMethod
    {
        private int n;
        private double[] k = new double[4];
        private double[] y, x, f;
        private Func<double, double, double> F = (x, y) => 1.6 * x + 0.5 * y;
        private double h, y1, y2, accurate, end;

        private void Start()
        {
            h = h / 10;
            n = n * 10;
            y = new double[n + 1];
            x = new double[n + 1];
            f = new double[n + 1];
            RungeKuttPart();
            MilnPart();
        }

        public void Start(double _y0, double _x0, double _end, double _accurate)
        {
            this.end = _end;
            this.accurate = _accurate;
            this.n = (int)((end - _x0) / 0.1);
            this.h = Math.Round((end - _x0) / n, 2);
            y = new double[n + 1];
            x = new double[n + 1];
            f = new double[n + 1];
            this.y[0] = _y0;
            this.x[0] = _x0;
            RungeKuttPart();
            MilnPart();
        }


        private void MilnPart()
        {
            for (int i = 4; i <= n; i++)
            {
                x[i] = x[i - 1] + 0.1;
                y1 = (y[i - 4] + 4 * h / 3 * (2 * f[i - 3] - f[i - 2] + 2 * f[i - 1]));
                f[i] = (F(x[i], y1));
                y2 = (y[i - 2] + h / 3 * (f[i - 2] + 4 * f[i - 1] + f[i]));
                if (!((Math.Abs((y2 - y1) / 29)) < accurate))
                {
                    this.Start();
                }
                else
                { y[i] = y2; f[i] = (F(x[i], y[i])); }
            }
        }
        private void RungeKuttPart()
        {
            for (int i = 0; i < 3; i++)
            {
                k[0] = (h * F(x[i], y[i]));
                k[1] = (h * F(x[i] + h / 2, y[i] + k[0] / 2));
                k[2] = (h * F(x[i] + h / 2, y[i] + k[1] / 2));
                k[3] = (h * F(x[i] + h, y[i] + k[2]));
                y[i + 1] = (y[i] + (1.0 / 6) * (k[0] + 2 * k[1] + 2 * k[2] + k[3]));
                x[i + 1] = x[i] + h;
                f[i] = (F(x[i], y[i]));
            }
            f[3] = (F(x[3], y[3]));
        }
        public double[] GetX
        {
            get
            {
                return this.x;
            }
        }
        public double[] GetY
        {
            get
            {
                return this.y;
            }
        }
        public int GetCount
        {
            get
            {
                return this.n;
            }
        }
    }
}
