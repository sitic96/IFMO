using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BST
{
    class Tree<T> where T : IComparable<T>
    {
        private T value;
        private Tree<T> left;
        private Tree<T> right;

        // вставка
        public void Insert(T value)
        {
            if (this.value.Equals(default(T)))
                this.value = value;
            else
            {
                if (this.value.CompareTo(value) == 1)
                {
                    if (left == null)
                        this.left = new Tree<T>();
                    left.Insert(value);
                }
                else
                {
                    if (right == null)
                        this.right = new Tree<T>();
                    right.Insert(value);
                }
            }
        }
        // поиск
        public bool Search(T value)
        {
            if (this.value.Equals(value))
                return true;

            else if (this.value.CompareTo(value) == 1)
            {
                if (left != null)
                    return this.left.Search(value);
                else
                    return false;
            }
            else
            {
                if (right != null)
                    return this.right.Search(value);
                else
                    return false;
            }
        }
    }
}
