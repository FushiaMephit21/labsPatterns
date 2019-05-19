using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Composite
{
    class Program
    {
        static void Main(string[] args)
        {
            Shape jacobs1 = new Jacobs();
            Shape jacobs2 = new Jacobs();
            Shape nescoffe1 = new Nescoffe();
            Shape jacobs3 = new Jacobs();

            Shape maccoffe1 = new Maccoffe();
            Shape maccoffe2 = new Maccoffe();
            Shape maccoffe3 = new Maccoffe();

            Composite composit = new Composite();
            Composite compositeJacobs = new Composite();
            Composite compositeNescoffe = new Composite();
            Composite compositeMaccoffe = new Composite();

            compositeJacobs.addComponents(jacobs1);
            compositeJacobs.addComponents(jacobs2);
            compositeNescoffe.addComponents(nescoffe1);

            compositeJacobs.addComponents(jacobs3);
            compositeMaccoffe.addComponents(maccoffe1);
            compositeMaccoffe.addComponents(maccoffe2);
            compositeMaccoffe.addComponents(maccoffe3);

            composit.addComponents(compositeJacobs);
            composit.addComponents(compositeNescoffe);
            composit.addComponents(compositeMaccoffe);

            composit.draw();

            Console.ReadKey();
        }
    }

    interface Shape
    {
        void draw();
    }

    class Jacobs : Shape
    {
        public void draw()
        {
            Console.WriteLine("Jacobs");
        }
    }   

    class Nescoffe : Shape
    {
	    public void draw()
        {
	        Console.WriteLine("Nescoffe");
        }
    }

    class Maccoffe : Shape
    {
	    public void draw()
        {
	        Console.WriteLine("Maccoffe");
        }
    }

    class Composite : Shape
    {
        private List<Shape> components = new List<Shape>();
	    //private List<Shape> components = new ArrayList<>();
        public void addComponents(Shape component)
        {
	        components.Add(component);
        }
        public void removeComponents(Shape component)
        {
	        components.Remove(component);
        }
        public void draw()
        {
	        foreach (Shape component in components)
	        {
		        component.draw();
	        }
        }
    }
}
