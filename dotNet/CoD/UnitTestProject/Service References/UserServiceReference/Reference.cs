﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré par un outil.
//     Version du runtime :4.0.30319.34209
//
//     Les modifications apportées à ce fichier peuvent provoquer un comportement incorrect et seront perdues si
//     le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

namespace UnitTestProject.UserServiceReference {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="UserServiceReference.IUserService")]
    public interface IUserService {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/addUser", ReplyAction="http://tempuri.org/IUserService/addUserResponse")]
        void addUser(string email, string mdp);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/addUser", ReplyAction="http://tempuri.org/IUserService/addUserResponse")]
        System.Threading.Tasks.Task addUserAsync(string email, string mdp);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/isConnectionOK", ReplyAction="http://tempuri.org/IUserService/isConnectionOKResponse")]
        bool isConnectionOK(string email, string mdp);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/isConnectionOK", ReplyAction="http://tempuri.org/IUserService/isConnectionOKResponse")]
        System.Threading.Tasks.Task<bool> isConnectionOKAsync(string email, string mdp);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/getListUsers", ReplyAction="http://tempuri.org/IUserService/getListUsersResponse")]
        string getListUsers();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IUserService/getListUsers", ReplyAction="http://tempuri.org/IUserService/getListUsersResponse")]
        System.Threading.Tasks.Task<string> getListUsersAsync();
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IUserServiceChannel : UnitTestProject.UserServiceReference.IUserService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class UserServiceClient : System.ServiceModel.ClientBase<UnitTestProject.UserServiceReference.IUserService>, UnitTestProject.UserServiceReference.IUserService {
        
        public UserServiceClient() {
        }
        
        public UserServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public UserServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UserServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public UserServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public void addUser(string email, string mdp) {
            base.Channel.addUser(email, mdp);
        }
        
        public System.Threading.Tasks.Task addUserAsync(string email, string mdp) {
            return base.Channel.addUserAsync(email, mdp);
        }
        
        public bool isConnectionOK(string email, string mdp) {
            return base.Channel.isConnectionOK(email, mdp);
        }
        
        public System.Threading.Tasks.Task<bool> isConnectionOKAsync(string email, string mdp) {
            return base.Channel.isConnectionOKAsync(email, mdp);
        }
        
        public string getListUsers() {
            return base.Channel.getListUsers();
        }
        
        public System.Threading.Tasks.Task<string> getListUsersAsync() {
            return base.Channel.getListUsersAsync();
        }
    }
}