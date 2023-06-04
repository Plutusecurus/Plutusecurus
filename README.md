# Plutusecurus
![0icwVZ2TZztq_1024_500](https://github.com/Plutusecurus/Plutusecurus/assets/75166805/3465a353-0619-400a-a5b0-2d5867f07bb0)

## ⭐ Project Description

Plutusecurus is an Android app that harnesses the Ethereum Smart Contracts Technology coupled with Fait Currency (INR) Payment Gateways to allow smooth and seamless cross-currency payments by scanning our QR Code.
It is an all-in-one finance solution based on Ethereum for all your online and offline payments. 

It helps users to:
* Have a one stop solution to all their cross-currency (INR-ETH) payments issues built on WEB3
* Provide Security and Accessibility to the user's data
* Manage their spendings and stay organized
* Be motivated to save more and start investing

## 📃 Getting Started
  *Clone the Repository*
  
  ```bash
  git clone https://github.com/shagil77/Plutusecurus
```
[*Download the Application*](https://drive.google.com/drive/folders/1qhQvWmiZ3ByVY6IkPVEI-kjt40UngR44?usp=sharing)

## 💭 Features

* Daily Payment and Expense Tracker using DeFi
* Easy to use user interface
* One Click Payment through QR codes
* Payment Through Decentralized Wallet

## Important Links

[Deployment Link](http://plutusecurus-ecs-load-balancer-583855892.us-east-1.elb.amazonaws.com/)

## 🧑‍💻 Tech Stack

### Front End: 
* Android Studio 
* JAVA 
* XML 
### Back End: 
* Node.js 
* Solidity 
* Express.js 
* Ethers.js
* Javascript 
* Socket.io
### Deployment: 
* Amazon Web Services (AWS) Elastic Container Service (ECS) 
* Docker Container
* Application Load Balancer

### AWS ECS

We have utilized the following applications in AWS ECS:

* AWS ECR (Elastic Container Registry) - We pushed our docker image to an ECR registry repository and leveraged the image version control provided by ECR (similar to Git).
* AWS ECS (Elastic Container Service) - We employed ECS to create and execute our service for our task definition containing the running Docker Image retrieved from AWS ECR Repository.
* Application Load Balancer - We employed an Application Load Balancer to regulate in-bound traffic and direct it towards one of the two active tasks for our ECS Service, as well as to conceal the Public IP of the ECS server instance and the PORT NUMBER it is listening to.

### MongoDB Atlas

We have used the NoSQL database service of MongoDB as the database for our app.

As a whole, the free credits from AWS, as well as their detailed documentation has helped us to deploy our project to be used for public use. We are grateful to AWS for helping aspiring developers like us to realise our potentials

## 💡Demo
[Link to Demo Video]([https://www.youtube.com/watch?v=9TaKodTJnA8](https://drive.google.com/file/d/1vaGFZec9QX0HcLpgrFAoDDMAYK4_szC9/view?usp=sharing))

## 💁 Contributors

Thanks to these amazing people! 👏
<table>
  <tr>
    <td align="center"><a href="https://github.com/Suswan114"><img src="https://avatars.githubusercontent.com/u/67154528?v=4" width="100px;" alt=""/><br /><sub><b>Suswan Biswas</b></sub></a><br /><a href="" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/shagil77"><img src="https://avatars.githubusercontent.com/u/75166805?v=4" width="100px;" alt=""/><br /><sub><b>Shagil Islam</b></sub></a><br /><a href="" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/sahaAnubhab"><img src="https://avatars.githubusercontent.com/u/77684836?v=4" width="100px;" alt=""/><br /><sub><b>Anubhab Saha</b></sub></a><br /><a href="" title="Code">💻</a></td>
    <td align="center"><a href="https://github.com/sayantandasgupta"><img src="https://avatars.githubusercontent.com/u/61374798?v=4" width="100px;" alt=""/><br /><sub><b>Sayantan Dasgupta</b></sub></a><br /><a href="" title="Code">💻</a></td>
   
   
  </tr>
</table>



  
