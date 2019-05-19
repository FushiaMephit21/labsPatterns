using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Flyweight
{
    class Program
    {
        static void Main(string[] args)
        {
            ShapeFactory shapeFactory = new ShapeFactory();

            List<Shape> shapes = new List<Shape>();
            //List<Shape> shapes = new ArrayList<>();

            shapes.Add(shapeFactory.getShape("квадрат"));
            shapes.Add(shapeFactory.getShape("круг"));
            shapes.Add(shapeFactory.getShape("круг"));
            shapes.Add(shapeFactory.getShape("точка"));
            shapes.Add(shapeFactory.getShape("квадрат"));
            shapes.Add(shapeFactory.getShape("круг"));

            Random rand = new Random();
            foreach (Shape shape in shapes)
            {
                int x = rand.Next(100);
                int y = rand.Next(100);
                shape.draw(x, y);
            }
        }
    }

    interface Shape
    {
        void draw(int x, int y);
    }

    class Point : Shape
    {
        public void draw(int x, int y)
        {
            Console.WriteLine("[" + x + ", " + y + "] : рисуем точку");
        }
    }

    class Circle : Shape
    {
        int r = 5;
        public void draw(int x, int y)
        {
            Console.WriteLine("[" + x + ", " + y + "] : рисуем круг радиусом " + r);
        }
    }

    class Square : Shape
    {
        int a=10;
        public void draw(int x, int y)
        {
            Console.WriteLine("[" + x + ", " + y + "] : рисуем квадрат со стороной " + a);
        }
    }

    class ShapeFactory
    {
        //private static Map<string, Shape> shapes = new Map<string, Shape>();
        private static Hashtable<string, Shape> shapes = new Hashtable<string, Shape>();
        public Shape getShape(string shapeName)
        {
            Shape shape = shapes.Keys;
            if (shape == null)
            {
                switch (shapeName)
                {
                    case "круг":
                        shape = new Circle();
                        break;
                    case "квадрат":
                        shape = new Square();
                        break;
                    case "точка":
                        shape = new Point();
                        break;
                }
                shapes.Put(shapeName, shape);
            }
            return shape;
        }
    }
}
