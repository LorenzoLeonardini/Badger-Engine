#include <Badger.h>

class ExampleLayer : public Badger::Layer {
public:
    ExampleLayer() : Layer("Example") {

    }

    void OnUpdate() override {
        BADGER_INFO("ExampleLayer::Update");
    }

    void OnEvent(Badger::Event &event) override {
        BADGER_TRACE("{0}", event);
    }
};

class Sandbox : public Badger::Application {
public:
    Sandbox() {
        PushLayer(new ExampleLayer());
        PushOverlay(new Badger::ImGuiLayer());
    }

    ~Sandbox() {

    }
};

Badger::Application *Badger::CreateApplication() {
    return new Sandbox();
}
