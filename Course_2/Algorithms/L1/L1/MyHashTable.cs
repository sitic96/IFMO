using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace L1
{
    class MyHashTable
    {
        private string[] array;
        private int hash, count;
        public int collisionCount, compareCount, p;
        public MyHashTable(int capacity)
        {
            if (capacity > 0)
            {
                array = new string[capacity];
            }
            else { throw new FormatException(); }
        }

        public MyHashTable()
        {
            array = new string[5000];
        }

        public void Add(string item)
        {
            if (item == null || item.Length < 2)
            {
                throw new FormatException();
            }
            else
            {
                Insert(item);
            }
        }

        private void Insert(string item)
        {
            if (array.Length == count)
            {
                Array.Resize(ref array, (int)(array.Length * 1.5));
            }
            int hash = GetHashCode(item);
            if (hash > array.Length)
            {
                Array.Resize(ref array, (int)(hash * 1.5));
            }
            if (array[hash] == null)
            {
                array[hash] = item;
                count++;
            }
            else
            {
                p++;
                SolveCollision(item, hash);

            }
        }

        private void SolveCollision(string item, int hash)
        {

            int newHash = hash + 1;
            if (newHash == array.Length) { newHash = 0; }
            if (array[hash] != item)
            {
                collisionCount++;
                while (hash != newHash)
                {
                    if (array[newHash] == null)
                    {
                        array[newHash] = item;
                        count++;
                        return;
                    }
                    else
                    {
                        SolveCollision(item, newHash);
                        return;
                    }
                }
                throw new ArgumentOutOfRangeException("К сожалению, в списке нет места.");
            }
        }

        private int GetHashCode(string item)
        {
            hash = item[0] + item[1];
            return hash;
        }

        public int Find(string item)
        {
            int hash = GetHashCode(item);
            compareCount++;
            if (array[hash] == null)
            {
                throw new KeyNotFoundException();
            }
            else
            {
                compareCount++;
                if (array[hash] == item)
                {
                    return hash;
                }
                else
                {
                    int newHash = hash + 1;
                    while (newHash % array.Length != hash)
                    {
                        compareCount++;
                        if (array[newHash] == item)
                        {
                            //compareCount++;
                            return newHash;
                        }

                        else
                        {
                            newHash++;
                            if (newHash == array.Length) { newHash = 0; }
                            /*if (array[newHash] == null)
                            {
                                newHash++;
                                while (array[newHash] == null)
                                {
                                    newHash++;
                                }
                            }
                            */
                        }
                    }
                    return -1;
                }
            }
        }

    }
}
