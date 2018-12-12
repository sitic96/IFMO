using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BST
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int j = 0; j < 15; j++)
            {
                Tree<int> tree = new Tree<int>();
                // var j = 15;
                int lastInsertElement = new int();
                using (StreamReader sr = new StreamReader((j + 1) + ".txt"))
                {

                    while (!sr.EndOfStream)
                    {
                        string[] line = sr.ReadLine().Split(new char[] { ' ' });
                        for (int i = 0; i < line.Length; i++)
                        {
                            if (line[i] == "")
                            {
                                break;
                            }
                            int element = Convert.ToInt32(line[i]);
                            tree.Insert(element);
                            lastInsertElement = element;
                        }
                    }
                }
                Stopwatch sw = new Stopwatch();
                sw.Start();
                lastInsertElement = 7;
                bool isFind = tree.Search(lastInsertElement);
                sw.Stop();
                Console.WriteLine(sw.ElapsedTicks);
            }
            Console.ReadKey();
        }
    }
}


