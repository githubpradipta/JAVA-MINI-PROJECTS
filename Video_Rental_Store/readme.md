# Video Rental Store / Inventory:
---
## Pre-requirements:

- Make sure you have ``java`` >=14 version installed in your system.

- ``Git`` mush be instakked to clone this repository.
## Installation:

- Clone this repository to your local system:

```shell

git clone https://github.com/githubpradipta/JAVA-MINI-PROJECTS.git

```

- Change the directory:

```shell

cd Video_Rental_Store
```
- Now run:

```shell

javac VideoStore.java
java VideoStore
```

## Description:

This is a simple mini java project to create a video rental inventory where you can rend any video or movie also can add a new video by yourself and can also edit the properties of them.

You can list out all the videos that the in ventory has and check the properties of it, is any video is already rented or not and can rent a video accordingly.

### Procedure:

- Firstly you have to make an instance of ``Store`` class.

``` java

Store store_1 = new Store();
```

- For adding a video to the inventory ``addVideo(String name)`` method is needed.

```java
store_1.addVideo("Title of the video");
```

- You can set any reating to a perticuler video by ``receiveRating(String name, double rating)`` method.

```java
store_1.addVideo("Title of the video",4.5);
```

- For rent an available video ``checkOut(String name)`` method should be used.

```java
store_1.checkOut("Title of the video");
```

- For return any video from rent there is ``returnVideo(String name)`` method.

```java
store_1.returnVideo("Title of the video");
```

- You can list out all the videos stored in the inventory of the shop by calling ``listInventory()`` method.

```java
store_1.listInventory();
```



