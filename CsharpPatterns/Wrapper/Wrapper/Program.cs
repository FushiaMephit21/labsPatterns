using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Wrapper
{
    class Program
    {
        static void Main(string[] args)
        {
            ChangeVideo printer = new ChangeSpeedDecorator(new RemoveFrameDecorator(new AddAdDecorator(new Change("==Відтворення реклами Jacobs=="))));
            printer.play();

            Console.ReadKey();
        }
    }

    interface ChangeVideo
    {
        void play();
    }

    class Change : ChangeVideo
    {
        string value;
        public Change(String value) { this.value = value; }
        public virtual void play()
        {
            Console.WriteLine(value);
        }
    }

    abstract class Decorator : ChangeVideo
    {
        public ChangeVideo component;
        public Decorator(ChangeVideo component) { this.component = component; }

        public virtual void play()
        {
            throw new NotImplementedException();
        }
    }

    class ChangeSpeedDecorator : Decorator
    {
        public ChangeSpeedDecorator(ChangeVideo component) : base(component) { }
        public override void play()
        {
            Console.WriteLine("Відтворити прискорено");
            component.play();
            Console.WriteLine("Відтворити скорочено");
        }
    }

    class RemoveFrameDecorator : Decorator
    {
        public RemoveFrameDecorator(ChangeVideo component) : base(component) { }
        public override void play()
        {
            component.play();
            Console.WriteLine("Вирізати кадри");
        }
    }

    class AddAdDecorator : Decorator
    {
        public AddAdDecorator(ChangeVideo component) : base(component) { }
        public override void play()
        {
            Console.WriteLine("Накласти поверх відео додаткову рекламу");
            component.play();
        }
    }
}
