using System;

namespace DoubleIntegrals
{
    class CalculateDoubleIntegral
    {
        private double h = 0, result;
        private Func<double, double, double> f = (double x, double y) => x * y;

        public double Start(double a, double b, double c, double d, int m)
        {
            double dx = (b - a) / m;
            double dy = (d - c) / m;
            double x0, y0, x1, y1;




            x0 = a;
            for (int i = 1; i < m + 1; i++)
            {
                x1 = x0 + dx;
                y0 = c;
                for (int j = 1; j < m + 1; j++)
                {
                    y1 = y0 + dy;
                    result += f((x0 + x1) / 2, (y0 + y1) / 2); //накопление интегральной суммы
                    y0 = y1;
                }
                x0 = x1;
            }

            return result *= dx * dy;
        }
    }
}
