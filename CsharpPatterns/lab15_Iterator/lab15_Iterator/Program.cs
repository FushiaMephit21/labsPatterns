using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab15_Iterator
{
    class IteratorApp
    {
        public static void Main(String[] args)
        {
            ConcreteCollection c = new ConcreteCollection();

            Iterator it = c.getIterator();

            while (it.hasMore())
            {
                Console.WriteLine((string)it.getNext());
            }

            Console.ReadKey();
        }
    }

    interface Iterator
    {
        bool hasMore();
        Object getNext();
    }

    interface IterableCollection
    {
        Iterator getIterator();
    }

    class ConcreteCollection : IterableCollection
    {
        static string[] tasks = { "Jacobs", "Nescafe", "MacCoffe"};

        public Iterator getIterator()
    {
        return new ConcreteIterator();
    }

    private class ConcreteIterator : Iterator
    {
        int index = 0;
        public bool hasMore()
    {
        if (index < tasks.Length) { return true; } else { return false; }
    }
        public Object getNext()
    {
        return tasks[index++];
    }
}
}}
