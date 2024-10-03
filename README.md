<center>
	<h1 align="center">React J - SWING</h1>
</center>
<p align="center">
<a href="https://app.codacy.com/gh/nbrugger-tgm/reactj?utm_source=github.com&utm_medium=referral&utm_content=nbrugger-tgm/reactj&utm_campaign=Badge_Grade_Settings"><img src="https://api.codacy.com/project/badge/Grade/f0aa98c14a794c419f8400de14e3dbc8"></a><br/>
<a href="https://www.conventionalcommits.org/en/v1.0.0/"><img src="https://img.shields.io/badge/conventional%20commits-✔-brightgreen"/></a>
</p>

<p align="center">
    This libary is an extension to <b><a>ReactJ</a></b> that adds a swing specific implementation.
Its just like <b>Vue js</b> for java/swing
</p>

ReactJ : [Repo](https://github.com/nbrugger-tgm/reactj) [Wiki](https://github.com/nbrugger-tgm/reactj/wiki)

Changelog : [Changelog.md](CHANGELOG.md)

# SUNSET
Together with the parent project ReactJ this is sunsetting. This project was intended to learn how to publish a project keep a project clean and publishing it. Its usefullness is limited and will not be updated any longer

### Usage

Version: [![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fniton.jfrog.io%2Fartifactory%2Fjava-libs%2Fcom%2Fniton%2Freactj%2Fswing%2Fmaven-metadata.xml)](https://niton.jfrog.io/ui/packages/gav:%2F%2Fcom.niton.reactj:swing?name=reactj-swing&type=packages)

#### Gradle

```groovy
repositories {
    maven {
        url "https://niton.jfrog.io/artifactory/java-libs/"
    }
}
```

Adding the dependency

```groovy
implementation 'com.niton.reactj:swing:0.1.1'
```

#### Maven

```xml
<repositories>
  <repository>
    <id>niton</id>
    <name>niton</name>
    <url>https://niton.jfrog.io/artifactory/java-libs/</url>
  </repository>
</repositories>
```

Adding the dependency

```xml
<dependency>
  <groupId>com.niton.reactj</groupId>
  <artifactId>swing</artifactId>
  <version>0.1.1</version>
</dependency>
```

### Example

> All functional examples can be found at https://github.com/nbrugger-tgm/reactj-swing/tree/master/src/test/java/com/niton/reactj/examples

Create a View

```java
public class DataView extends JRComponent<ReactiveProxy<Data>> {
    private JPanel            panel;
    
    //The R marks reactive components
    private JRTextField        nameInput;
    private JRComboBox<Gender> genderJComboBox;
    private JRButton           selectButton ;
    
    public DataView(DataController controller) {
        super(controller);
    }
    
    @Override
    protected JPanel createView() {
        panel           = new JPanel();
        
        nameInput       = new JRTextField();
        genderJComboBox = new JRComboBox<>();
        selectButton    = new JRButton("Reset");
        genderJComboBox.setModel(new DefaultComboBoxModel<>(Gender.values()));
        
        nameInput.setColumns(10);
        
        panel.add(nameInput);
        panel.add(genderJComboBox);
        panel.add(selectButton);
        
        return panel;
    }
    
    @Override
    public void createBindings(ReactiveBinder bindings) {
        nameInput.biBindText("name", binder);
        genderJComboBox.biBindSelectedItem("gender",binder);
    }
}
```

Then we need a Pojo/Model to sync the View with

```java
public class Data { 
	//change reactive name
	@Reactive("gender")
	private Gender personsGender;
	private String name;

	//This will not be reacted to
	@Unreactive
	private String address;

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(Gender gender) {
		this.personsGender = gender;
	}
}
```

Now we need to bind the view to a Person object

```java
ReactiveProxy<Data> proxy = ReactiveObject.create(Data.class);
Data model = proxy.object;
DataView view = new DataView();
view.setData(proxy);

//now you just need to display the view on a JFrame
```

### Full runnable example

https://github.com/nbrugger-tgm/todo-list
