using System;

namespace Integrals
{
    class SolveIntegr
    {
        private double h, accuracy, answer1, answer2, a, b;
        private int primer, n = 10;
        private delegate double return_x(double x);

        
        public void Start(int primer_number, double _a, double _b, double _accuracy)
        {
            this.a = _a;
            this.b = _b;
            this.primer = primer_number;
            return_x rx = null;
            switch (primer)
            {
                case 1:
                    { rx = x => 7 / (x * x + 1); } break;
                case 2:
                    { rx = x => 2 * x * x; } break;
                case 3:
                    { rx = x => Math.Sin(x) * Math.Cos(x); } break;
                case 4:
                    { rx = x => 5 * x * x / 3; } break;
                case 5:
                    { rx = x => Math.Pow(Math.E, x); } break;
            }
            this.accuracy = _accuracy;
            this.Solve(rx);
        }

        private void Solve(return_x rx)
        {
            while (true)
            {
                h = (b - a) / n;
                for (int i = 0; i < n; i++)
                {
                    if (i == 0)
                    {
                        answer1 = rx(a + i * h);
                    }
                    else if (i < n - 1)
                    {
                        answer1 += 2 * rx(a + i * h);
                    }
                    else
                    {
                        answer1 += (rx(a + i * h));
                    }
                }
                answer1 = h / 2 * answer1;
                n = n * 2;
                h = (b - a) / n;
                for (int i = 0; i < n; i++)
                {
                    if (i == 0)
                    {
                        answer2 = rx(a + i * h);
                    }
                    else if (i < n - 1)
                    {
                        answer2 += 2 * rx(a + i * h);
                    }
                    else
                    {
                        answer2 += (rx(a + i * h));
                    }
                }
                answer2 = h / 2 * answer2;
                if (Math.Abs(answer2 - answer1) < accuracy)
                {
                    this.n = n;
                    break;
                }
                else n = n * 2;
            }
        }
        public int GetN
        {
            get
            {
                return this.n;
            }
        }
        public double GetAnswer
        {
            get
            {
                return Math.Abs(this.answer2);
            }
        }
        public double GetPogr
        {
            get
            {
                return Math.Abs(answer2 - answer1) / 3;
            }
        }
    }
}
