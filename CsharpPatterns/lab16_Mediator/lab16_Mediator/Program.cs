using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab16_Mediator
{
    class Program
    {
        static void Main(string[] args)
        {
            TextChat chat = new TextChat();

            User admin = new Admin(chat, "Иван Иваныч");
            User u1 = new SimpleUser(chat, "Ваня");
            User u2 = new SimpleUser(chat, "Вова");
            User u3 = new SimpleUser(chat, "Саша");
            u2.setEnable(false);

            chat.setAdmin(admin);
            chat.addUser(u1);
            chat.addUser(u2);
            chat.addUser(u3);

            admin.sendMessage("Привет");

            Console.ReadKey();
        }
    }

    abstract class User
    {
        Chat chat;
        String name;
        bool Enable = true;

        public bool getEnable() { return Enable; }
        public void setEnable(bool Enable) { this.Enable = Enable; }

        public User(Chat chat, String name) { this.chat = chat; this.name = name; }

        public String getName() { return name; }

        public void sendMessage(String message)
        {
            chat.sendMessage(message, this);
        }

        public abstract void getMessage(String message);
        public String toString()
            {
                return "User [name=" + name + "]";
            }
    }

    class Admin : User
    {
        public Admin(Chat chat, String name) : base(chat, name) { }

        public override void getMessage(String message)
        {
            Console.WriteLine("Пользователь " + getName() + " плучает сообщение '" + message + "'");
        }
    }

    class SimpleUser : User
    {
        public SimpleUser(Chat chat, String name) : base(chat, name) { }

        public override void getMessage(String message)
        {
            Console.WriteLine("Пользователь " + getName() + " получает ссобщение '" + message + "'");
        }
    }

    interface Chat
    {
        void sendMessage(String message, User user);
    }

    class TextChat : Chat
    {
        User admin;
        List<User> users = new List<User>();

        public void setAdmin(User admin)
        {
            if (admin != null && admin is Admin) {
            this.admin = admin;
        }
        else {
            throw new Exception("Не хватает прав");
        }
        }

        public void addUser(User u)
        {
            if (admin == null)
            {
                throw new Exception("В чате нет админа!");
            }

            if (u is SimpleUser) {
                users.Add(u);
            }
                else {
                    throw new Exception("Админ не может вхожить в другой чат");
                }
            }

        public void sendMessage(String message, User user)
        {
            if (user is Admin) {
                foreach (User u in users)
                {
                    u.getMessage(user.getName() + ": " + message);
                }
            }
            if (user is SimpleUser) {
                foreach (User u in users)
                {
                    if (u != user && u.getEnable())
                    u.getMessage(user.getName() + ": " + message);
                }
                if (admin.getEnable())
                    admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}
