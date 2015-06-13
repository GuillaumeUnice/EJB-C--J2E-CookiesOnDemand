using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace CoD
{
    public class UserDAO
    {
        private static UserDAO instance;
        public static UserDAO Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new UserDAO();
                }
                return instance;
            }
        }
        /// <summary>
        /// Liste tous les utilisateurs
        /// </summary>
        public List<User> getListUsers()
        {
            using (CoDEntities modele = new CoDEntities())
            {
                var requete = from user in modele.User
                              select user;
                return requete.ToList<User>();
            }
        }

        /// <summary>
        /// Ajouter Utilisateur
        /// </summary>
        public void addUser(String email, String mdp)
        {
            try
            {
                using (CoDEntities modele = new CoDEntities())
                {
                    User user = new User
                    {
                        Email = email,
                        Mdp = mdp
                    };
                    modele.User.Add(user);
                    modele.SaveChanges();
                }
            } catch(Exception e) {}
        }

        ///<summary>
        /// Répond oui ou non à la connexion
        /// </summary>
        public bool isConnectionOK(String email, String mdp)
        {
            using (CoDEntities modele = new CoDEntities())
            {
                var requete = from user in modele.User
                              where user.Email == email && user.Mdp == mdp
                              select user;
                if (requete.Count() == 1) return true;
            }
            return false;
        }
    }
}