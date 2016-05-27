using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace L1
{
    class Program
    {
        static void Main(string[] args)
        {
            MyHashTable mht = new MyHashTable(30);
            mht.Add("ЯЯllo");
            mht.Add("My");
            mht.Add("Baby");
            mht.Add("Hell");
            mht.Add("Bad");
            Console.WriteLine(mht.Find("Hell"));
            Console.ReadKey();
        }
    }
}
