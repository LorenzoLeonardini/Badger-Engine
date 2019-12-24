#pragma once

#include "Badger/Layer.h"

#include "Badger/Events/ApplicationEvent.h"
#include "Badger/Events/KeyEvent.h"
#include "Badger/Events/MouseEvent.h"

namespace Badger {

    class BADGER_API ImGuiLayer : public Layer {
    public:
        ImGuiLayer();
        ~ImGuiLayer();

        void OnAttach();
        void OnDetach();
        void OnUpdate();
        void OnEvent(Event &event);
    private:
        bool OnMouseButtonPressedEvent(MouseButtonPressedEvent &e);
        bool OnMouseButtonReleasedEvent(MouseButtonReleasedEvent &e);
        bool OnMouseMovedEvent(MouseMovedEvent &e);
        bool OnMouseScrolledEvent(MouseScrolledEvent &e);
        bool OnKeyPressedEvent(KeyPressedEvent &e);
        bool OnKeyReleasedEvent(KeyReleasedEvent &e);
        bool OnKeyTypedEvent(KeyTypedEvent &e);
        bool OnWindowResizeEvent(WindowResizeEvent &e);
    private:
        float m_Time = 0.0f;
    };

}
